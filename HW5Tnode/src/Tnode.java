import java.util.*;

public class Tnode {

    private String name;
    private Tnode firstChild;
    private Tnode nextSibling;

    private Tnode(String n, Tnode fC, Tnode nS) {
        name = n;
        firstChild = fC;
        nextSibling = nS;
    }

    private String getName() {
        return name;
    }

    private Tnode getFirstChild() {
        return firstChild;
    }

    private void setFirstChild(Tnode firstChild) {
        this.firstChild = firstChild;
    }

    private Tnode getNextSibling() {
        return nextSibling;
    }

    private void setNextSibling(Tnode nextSibling) {
        this.nextSibling = nextSibling;
    }

    @Override
    public String toString() {
        StringBuffer b = new StringBuffer();
        List<Tnode> usedList = new ArrayList<>();
        Tnode current = this;

        while (true) {
            if (!usedList.contains(current)) {
                b.append(current.getName());
                usedList.add(current);
            }

            Tnode child = current.getFirstChild();
            Tnode sibling = current.getNextSibling();

            if (child != null) {
                if (child.getNextSibling() == null && child.getFirstChild() == null) {
                    current.setFirstChild(null);
                    current = this;
                } else {
                    current = current.getFirstChild();
                }
                if (!usedList.contains(current)) {
                    b.append("(");
                }
            } else if (sibling != null) {
                if (sibling.getFirstChild() == null) {
                    current.setNextSibling(null);
                    if (!usedList.contains(sibling)) {
                        b.append(",").append(sibling.getName());
                    }
                    current = this;
                    b.append(")");
                } else {
                    current = current.getNextSibling();
                }
                if (!usedList.contains(current)) {
                    b.append(",");
                }
            }
            if (this.getFirstChild() == null) {
                break;
            }
        }
        return b.toString();
    }

    public static Tnode buildFromRPN(String pol) {
        List<Tnode> tnodeList = correctExpression(pol);
        int counter = 0;

        while (tnodeList.size() > 1) {
            if (tnodeList.size() > 2) {
                if (tnodeList.get(counter + 2).getName().equals("SWAP")) swap(tnodeList, counter);
            }

            if (tnodeList.size() > 3) {
                if (tnodeList.get(counter + 3).getName().equals("ROT")) rot(tnodeList, counter);
            }

            if (tnodeList.size() < 3 || isNumeric(tnodeList.get(tnodeList.size() - 1)))
                throw new RuntimeException("Avaldises " + pol + " ei ole piisavalt elemente tehte tegemiseks");

            if (isNumeric(tnodeList.get(counter))) {
                if (isNumeric(tnodeList.get(counter + 1))) {
                    if (!isNumeric(tnodeList.get(counter + 2))) {
                        Tnode top = tnodeList.get(counter + 2);
                        Tnode left = tnodeList.get(counter);
                        Tnode right = tnodeList.get(counter + 1);
                        if (top.name.equals("ROT")) {
                            throw new RuntimeException("Avaldises " + pol + " ei ole piisavalt elemente ROT tehte tegemiseks");
                        }
                        left.setNextSibling(right);
                        top.setFirstChild(left);
                        tnodeList.remove(counter + 1);
                        tnodeList.remove(counter);
                        counter = 0;
                        continue;
                    }
                }
            }
            counter++;
        }
        return tnodeList.get(0);
    }

    private static List<Tnode> correctExpression(String pol) {
        if (pol == null) throw new RuntimeException("Avaldis puudub!");
        pol = pol.trim().replaceAll(" +", " ");

        if (pol.equals(" ") || pol.equals("")) throw new RuntimeException("Avaldis puudub!");

        List<String> symbolList = Arrays.asList(pol.split(" "));
        List<Tnode> tnodeList = createTnodeList(symbolList);

        if (tnodeList.size() == 1 && !isNumeric(tnodeList.get(0)))
            throw new RuntimeException("Vigane sümbol " + tnodeList.get(0) + " avaldises " + pol);

        for (Tnode tnode : tnodeList) {
            if (!isNumeric(tnode) && !isSymbol(tnode))
                throw new RuntimeException("Vigane sümbol " + tnode.getName() + " avaldises " + pol);
        }

        if (tnodeList.size() > 1) {
            if (!isNumeric(tnodeList.get(0)) || !isNumeric(tnodeList.get(1))) {
                throw new RuntimeException("Avaldises " + pol + " ei ole piisavalt elemente tehte tegemiseks");
            }
        }
        return tnodeList;
    }

    private static boolean isNumeric(Tnode node) {
        try {
            Integer.parseInt(node.getName());
            return true;
        } catch (NumberFormatException e) {
            return node.firstChild != null;
        }
    }

    private static boolean isSymbol(Tnode node) {
        return (Arrays.asList("*", "/", "+", "-", "SWAP", "ROT").contains(node.getName()));
    }

    private static List<Tnode> createTnodeList(List<String> stringList) {
        List<Tnode> tnodeList = new ArrayList<>();
        for (String str : stringList) {
            tnodeList.add(new Tnode(str, null, null));
        }
        return tnodeList;
    }

    private static void swap (List<Tnode> tnodeList, int index) {
        Tnode first = tnodeList.get(index);
        Tnode second = tnodeList.get(index + 1);
        tnodeList.set(index + 1, first);
        tnodeList.set(index, second);
        tnodeList.remove(index + 2);
    }

    private static void rot (List<Tnode> tnodeList, int index) {
        Tnode first = tnodeList.get(index);
        Tnode second = tnodeList.get(index + 1);
        Tnode third = tnodeList.get(index + 2);
        tnodeList.set(index, second);
        tnodeList.set(index + 1, third);
        tnodeList.set(index + 2, first);
        tnodeList.remove(index + 3);
    }

    public static void main (String[] param) {
        String rpn = "2 5 9 ROT + SWAP -";
        System.out.println ("RPN: " + rpn);
        Tnode res = buildFromRPN (rpn);
        System.out.println ("Tree: " + res);

        String rpn2 = "2";
        System.out.println ("RPN2: " + rpn2);
        Tnode res2 = buildFromRPN (rpn2);
        System.out.println ("Tree2: " + res2);

        String rpn3 = "512 1 - 4 * -61 3 / ROT";
        System.out.println ("RPN3: " + rpn3);
        Tnode res3 = buildFromRPN (rpn3);
        System.out.println ("Tree3: " + res3);
    }
}
