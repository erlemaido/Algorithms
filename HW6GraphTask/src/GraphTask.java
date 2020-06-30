import java.util.*;

/**
 * Container class to different classes, that makes the whole
 * set of classes one class formally.
 */
public class GraphTask {

    /**
     * Main method.
     */
    public static void main(String[] args) {
        GraphTask a = new GraphTask();
        long stime = System.nanoTime();
        a.run();
        long ftime = System.nanoTime();
        long diff = ftime - stime;
        System.out.println("\n Time (ms): " + diff / 1000000);
    }

    /**
     * Actual main method to run examples and everything.
     */
    private void run() {
        Graph graph = new Graph("G");
//        GraphTask task = new GraphTask();
//
//        // TEST 1: mitmetipuline Euleri graaf
//        Vertex a = task.new Vertex("A");
//        Vertex b = task.new Vertex("B");
//        Vertex c = task.new Vertex("C");
//        Vertex d = task.new Vertex("D");
//        Vertex e = task.new Vertex("E");
//        Vertex f = task.new Vertex("F");
//        Vertex g = task.new Vertex("G");
//        Vertex h = task.new Vertex("H");
//        graph.first = a;
//        a.next = b;
//        b.next = h;
//        h.next = d;
//        d.next = g;
//        g.next = b;
//        c.next = f;
//        f.next = a;
//        e.next = a;
//        Arc ab = task.new Arc("A-B");
//        Arc ac = task.new Arc("A-C");
//        Arc ae = task.new Arc("A-E");
//        Arc af = task.new Arc("A-F");
//        Arc ba = task.new Arc("B-A");
//        Arc bd = task.new Arc("B-D");
//        Arc bg = task.new Arc("B-G");
//        Arc bh = task.new Arc("B-H");
//        Arc ca = task.new Arc("C-A");
//        Arc cd = task.new Arc("C-D");
//        Arc ce = task.new Arc("C-E");
//        Arc cf = task.new Arc("C-F");
//        Arc db = task.new Arc("D-B");
//        Arc dc = task.new Arc("D-C");
//        Arc dg = task.new Arc("D-G");
//        Arc dh = task.new Arc("D-H");
//        Arc ea = task.new Arc("E-A");
//        Arc ec = task.new Arc("E-C");
//        Arc fa = task.new Arc("F-A");
//        Arc fc = task.new Arc("F-C");
//        Arc gb = task.new Arc("G-B");
//        Arc gd = task.new Arc("G-D");
//        Arc hb = task.new Arc("H-B");
//        Arc hd = task.new Arc("H-D");
//        a.first = ab;
//        ab.next = ac;
//        ac.next = ae;
//        ae.next = af;
//        b.first = bh;
//        bh.next = bd;
//        bd.next = bg;
//        bg.next = ba;
//        c.first = cf;
//        cf.next = ca;
//        ca.next = ce;
//        ce.next = cd;
//        d.first = dg;
//        dg.next = db;
//        db.next = dh;
//        dh.next = dc;
//        e.first = ea;
//        ea.next = ec;
//        f.first = fa;
//        fa.next = fc;
//        g.first = gb;
//        gb.next = gd;
//        h.first = hd;
//        hd.next = hb;
//        ab.target = b;
//        ac.target = c;
//        ae.target = e;
//        af.target = f;
//        ba.target = a;
//        bd.target = d;
//        bg.target = g;
//        bh.target = h;
//        ca.target = a;
//        cd.target = d;
//        ce.target = e;
//        cf.target = f;
//        db.target = b;
//        dc.target = c;
//        dg.target = g;
//        dh.target = h;
//        ea.target = a;
//        ec.target = c;
//        fa.target = a;
//        fc.target = c;
//        gb.target = b;
//        gd.target = d;
//        hb.target = b;
//        hd.target = d;


        // TEST 2: mitmetipuline Euleri graaf
//        Vertex a = task.new Vertex("A");
//        Vertex b = task.new Vertex("B");
//        Vertex c = task.new Vertex("C");
//        Vertex d = task.new Vertex("D");
//        Vertex e = task.new Vertex("E");
//        Vertex f = task.new Vertex("F");
//        graph.first = a;
//        a.next = b;
//        b.next = c;
//        c.next = f;
//        f.next = e;
//        e.next = d;
//        d.next = a;
//        Arc ab = task.new Arc("A-B");
//        Arc ac = task.new Arc("A-C");
//        Arc ad = task.new Arc("A-D");
//        Arc ae = task.new Arc("A-E");
//        Arc ba = task.new Arc("B-A");
//        Arc bc = task.new Arc("B-C");
//        Arc ca = task.new Arc("C-A");
//        Arc cf = task.new Arc("C-F");
//        Arc ce = task.new Arc("C-E");
//        Arc cb = task.new Arc("C-B");
//        Arc de = task.new Arc("D-E");
//        Arc da = task.new Arc("D-A");
//        Arc ea = task.new Arc("E-A");
//        Arc ec = task.new Arc("E-C");
//        Arc ed = task.new Arc("E-D");
//        Arc ef = task.new Arc("E-F");
//        Arc fc = task.new Arc("F-C");
//        Arc fe = task.new Arc("F-E");
//        a.first = ab;
//        ab.next = ac;
//        ac.next = ad;
//        ad.next = ae;
//        b.first = bc;
//        bc.next = ba;
//        c.first = cb;
//        cb.next = ca;
//        ca.next = ce;
//        ce.next = cf;
//        d.first = da;
//        da.next = de;
//        e.first = ed;
//        ed.next = ea;
//        ea.next = ec;
//        ec.next = ef;
//        f.first = fe;
//        fe.next = fc;
//        ab.target = b;
//        ac.target = c;
//        ad.target = d;
//        ae.target = e;
//        ba.target = a;
//        bc.target = c;
//        ca.target = a;
//        cf.target = f;
//        ce.target = e;
//        cb.target = b;
//        de.target = e;
//        da.target = a;
//        ea.target = a;
//        ec.target = c;
//        ed.target = d;
//        ef.target = f;
//        fe.target = e;
//        fc.target = c;


        // TEST 3: mitmetipuline Euleri graaf
//        Vertex a = task.new Vertex("A");
//        Vertex b = task.new Vertex("B");
//        Vertex c = task.new Vertex("C");
//        Vertex d = task.new Vertex("D");
//        Vertex e = task.new Vertex("E");
//        Vertex f = task.new Vertex("F");
//        Vertex l = task.new Vertex("L");
//        graph.first = a;
//        a.next = b;
//        b.next = c;
//        c.next = f;
//        f.next = e;
//        e.next = d;
//        d.next = a;
//        l.next = f;
//        Arc ab = task.new Arc("A-B");
//        Arc ac = task.new Arc("A-C");
//        Arc ae = task.new Arc("A-E");
//        Arc ad = task.new Arc("A-D");
//        Arc ba = task.new Arc("B-A");
//        Arc bd = task.new Arc("B-D");
//        Arc bc = task.new Arc("B-C");
//        Arc bl = task.new Arc("B-L");
//        Arc ca = task.new Arc("C-A");
//        Arc cb = task.new Arc("C-B");
//        Arc ce = task.new Arc("C-E");
//        Arc cf = task.new Arc("C-F");
//        Arc db = task.new Arc("D-B");
//        Arc da = task.new Arc("D-A");
//        Arc de = task.new Arc("D-E");
//        Arc df = task.new Arc("D-F");
//        Arc ea = task.new Arc("E-A");
//        Arc ec = task.new Arc("E-C");
//        Arc ef = task.new Arc("E-F");
//        Arc ed = task.new Arc("E-D");
//        Arc fd = task.new Arc("F-D");
//        Arc fc = task.new Arc("F-C");
//        Arc fe = task.new Arc("F-E");
//        Arc fl = task.new Arc("F-L");
//        Arc lb = task.new Arc("L-B");
//        Arc lf = task.new Arc("L-F");
//        a.first = ab;
//        ab.next = ac;
//        ac.next = ae;
//        ae.next = ad;
//        b.first = bd;
//        bd.next = bc;
//        bc.next = ba;
//        ba.next = bl;
//        c.first = cf;
//        cf.next = ca;
//        ca.next = ce;
//        ce.next = cb;
//        d.first = da;
//        da.next = db;
//        db.next = df;
//        df.next = de;
//        e.first = ea;
//        ea.next = ec;
//        ec.next = ef;
//        ef.next = ed;
//        f.first = fc;
//        fc.next = fd;
//        fd.next = fe;
//        fe.next = fl;
//        l.first = lb;
//        lb.next = lf;
//        ab.target = b;
//        ac.target = c;
//        ae.target = e;
//        ad.target = d;
//        ba.target = a;
//        bd.target = d;
//        bc.target = c;
//        bl.target = l;
//        ca.target = a;
//        cb.target = b;
//        ce.target = e;
//        cf.target = f;
//        db.target = b;
//        da.target = a;
//        de.target = e;
//        df.target = f;
//        ea.target = a;
//        ec.target = c;
//        ed.target = d;
//        ef.target = f;
//        fd.target = d;
//        fc.target = c;
//        fe.target = e;
//        fl.target = l;
//        lb.target = b;
//        lf.target = f;


        // TEST 4: mitmetipuline Euleri graaf
//        Vertex a = task.new Vertex("A");
//        Vertex b = task.new Vertex("B");
//        Vertex c = task.new Vertex("C");
//        Vertex d = task.new Vertex("D");
//        Vertex e = task.new Vertex("E");
//        graph.first = a;
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = a;
//        Arc ab = task.new Arc("A-B");
//        Arc ac = task.new Arc("A-C");
//        Arc ad = task.new Arc("A-D");
//        Arc ae = task.new Arc("A-E");
//        Arc ba = task.new Arc("B-A");
//        Arc bd = task.new Arc("B-D");
//        Arc bc = task.new Arc("B-C");
//        Arc be = task.new Arc("B-E");
//        Arc ca = task.new Arc("C-A");
//        Arc cd = task.new Arc("C-D");
//        Arc ce = task.new Arc("C-E");
//        Arc cb = task.new Arc("C-B");
//        Arc db = task.new Arc("D-B");
//        Arc dc = task.new Arc("D-C");
//        Arc da = task.new Arc("D-A");
//        Arc de = task.new Arc("D-E");
//        Arc ea = task.new Arc("E-A");
//        Arc ed = task.new Arc("E-D");
//        Arc eb = task.new Arc("E-B");
//        Arc ec = task.new Arc("E-C");
//        a.first = ab;
//        ab.next = ac;
//        ac.next = ad;
//        ad.next = ae;
//        b.first = bc;
//        bc.next = bd;
//        bd.next = be;
//        be.next = ba;
//        c.first = cb;
//        cb.next = ca;
//        ca.next = cd;
//        cd.next = ce;
//        d.first = da;
//        da.next = db;
//        db.next = dc;
//        dc.next = de;
//        e.first = eb;
//        eb.next = ec;
//        ec.next = ea;
//        ea.next = ed;
//        ab.target = b;
//        ac.target = c;
//        ad.target = d;
//        ae.target = e;
//        ba.target = a;
//        bd.target = d;
//        bc.target = c;
//        be.target = e;
//        ca.target = a;
//        cd.target = d;
//        ce.target = e;
//        cb.target = b;
//        db.target = b;
//        dc.target = c;
//        da.target = a;
//        de.target = e;
//        eb.target = b;
//        ec.target = c;
//        ea.target = a;
//        ed.target = d;


        // TEST 5: mitmetipuline mitte Euleri graaf
//        Vertex a = task.new Vertex("A");
//        Vertex b = task.new Vertex("B");
//        Vertex c = task.new Vertex("C");
//        Vertex d = task.new Vertex("D");
//        Vertex e = task.new Vertex("E");
//        graph.first = a;
//        a.next = b;
//        b.next = e;
//        e.next = c;
//        c.next = d;
//        d.next = a;
//        Arc ab = task.new Arc("A-B");
//        Arc ac = task.new Arc("A-C");
//        Arc ad = task.new Arc("A-D");
//        Arc ba = task.new Arc("B-A");
//        Arc bd = task.new Arc("B-D");
//        Arc bc = task.new Arc("B-C");
//        Arc be = task.new Arc("B-E");
//        Arc ca = task.new Arc("C-A");
//        Arc cd = task.new Arc("C-D");
//        Arc ce = task.new Arc("C-E");
//        Arc cb = task.new Arc("C-B");
//        Arc db = task.new Arc("D-B");
//        Arc dc = task.new Arc("D-C");
//        Arc da = task.new Arc("D-A");
//        Arc eb = task.new Arc("E-B");
//        Arc ec = task.new Arc("E-C");
//        a.first = ab;
//        ab.next = ac;
//        ac.next = ad;
//        b.first = bc;
//        bc.next = bd;
//        bd.next = be;
//        be.next = ba;
//        c.first = cb;
//        cb.next = ca;
//        ca.next = cd;
//        cd.next = ce;
//        d.first = da;
//        da.next = db;
//        db.next = dc;
//        e.first = eb;
//        eb.next = ec;
//        ab.target = b;
//        ac.target = c;
//        ad.target = d;
//        ba.target = a;
//        bd.target = d;
//        bc.target = c;
//        be.target = e;
//        ca.target = a;
//        cd.target = d;
//        ce.target = e;
//        cb.target = b;
//        db.target = b;
//        dc.target = c;
//        da.target = a;
//        eb.target = b;
//        ec.target = c;

        // TEST 6: ühetipuline genereeritud graaf
//        graph.createRandomSimpleGraph(1, 0);

        // TEST 7: tühi genereeritud graaf
//        graph.createRandomSimpleGraph(0, 0);

        // TEST 8: mitmetipuline genereeritud Euleri graaf
//        graph.createRandomSimpleGraph(3, 3);

        // TEST 9: 2000+ tipuga graaf
//        graph.createRandomSimpleGraph(2200, 2800);

        // TEST 10: ajamõõtmiseks ja vastuse kuvamiseks; genereerib meetodiga 2000 tipuga Euleri graafi
        graph.createBigEulerianCycle(2000);

        graph.findPath();
    }

    /**
     * Vertex is the fundamental unit of which graphs are formed.
     */
    class Vertex {

        private String id;
        private Vertex next;
        private Arc first;
        private int info = 0;

        /**
         * Constructor.
         *
         * @param s id
         * @param v next vertex
         * @param e first arc
         */
        Vertex(String s, Vertex v, Arc e) {
            id = s;
            next = v;
            first = e;
        }

        /**
         * Constructor.
         *
         * @param s id
         */
        Vertex(String s) {
            this(s, null, null);
        }

        /**
         * Get first arc.
         *
         * @return arc
         */
        private Arc getFirst() {
            return first;
        }

        /**
         * Convert to string.
         *
         * @return vertex id
         */
        @Override
        public String toString() {
            return id;
        }
    }

    /**
     * Arc represents one arrow in the graph. Two-directional edges are
     * represented by two Arc objects (for both directions).
     */
    class Arc {

        private String id;
        private Vertex target;
        private Arc next;
        private int info = 0;
        private boolean visited = false;

        /**
         * Constructor.
         *
         * @param s id
         * @param v target vertex
         * @param a next arc
         */
        Arc(String s, Vertex v, Arc a) {
            id = s;
            target = v;
            next = a;
        }

        /**
         * Constructor.
         *
         * @param s id
         */
        Arc(String s) {
            this(s, null, null);
        }

        /**
         * Get id.
         *
         * @return arc id
         */
        private String getId() {
            return id;
        }

        /**
         * Get target vertex.
         *
         * @return vertex
         */
        private Vertex getTarget() {
            return target;
        }

        /**
         * Get next arc.
         *
         * @return arc.
         */
        private Arc getNext() {
            return next;
        }

        /**
         * Check if is visited.
         *
         * @return boolean
         */
        private boolean isVisited() {
            return visited;
        }

        /**
         * Get info.
         *
         * @return int
         */
        private int getInfo() {
            return info;
        }

        /**
         * Set visited.
         *
         */
        void setVisited() {
            this.visited = true;
        }

        /**
         * Set info.
         *
         * @param info info number
         */
        private void setInfo(int info) {
            this.info = info;
        }

        /**
         * Convert to string.
         *
         * @return arc id
         */
        @Override
        public String toString() {
            return id;
        }
    }

    /**
     * Graph is a set of vertices and arcs.
     */
    class Graph {

        private String id;
        private Vertex first;
        private int info = 0;

        /**
         * Constructor.
         *
         * @param s id
         * @param v first vertex
         */
        Graph(String s, Vertex v) {
            id = s;
            first = v;
        }

        /**
         * Constructor.
         *
         * @param s id
         */
        Graph(String s) {
            this(s, null);
        }

        /**
         * Get graph id.
         *
         * @return graph id
         */
        private String getId() {
            return id;
        }

        /**
         * Get first vertex.
         *
         * @return vertex
         */
        private Vertex getFirst() {
            return first;
        }

        /**
         * Convert to string
         *
         * @return graph
         */
        @Override
        public String toString() {
            String nl = System.getProperty("line.separator");
            StringBuffer sb = new StringBuffer(nl);
            sb.append(id);
            sb.append(nl);
            Vertex v = first;
            while (v != null) {
                sb.append(v.toString());
                sb.append(" -->");
                Arc a = v.first;
                while (a != null) {
                    sb.append(" ");
                    sb.append(a.toString());
                    sb.append(" (");
                    sb.append(v.toString());
                    sb.append("->");
                    sb.append(a.target.toString());
                    sb.append(")");
                    a = a.next;
                }
                sb.append(nl);
                v = v.next;
            }
            return sb.toString();
        }

        private Vertex createVertex(String vid) {
            Vertex res = new Vertex(vid);
            res.next = first;
            first = res;
            return res;
        }

        private Arc createArc(String aid, Vertex from, Vertex to) {
            Arc res = new Arc(aid);
            res.next = from.first;
            from.first = res;
            res.target = to;
            return res;
        }

        /**
         * Create a connected undirected random tree with n vertices.
         * Each new vertex is connected to some random existing vertex.
         *
         * @param n number of vertices added to this graph
         */
        private void createRandomTree(int n) {
            if (n <= 0)
                return;
            Vertex[] varray = new Vertex[n];
            for (int i = 0; i < n; i++) {
                varray[i] = createVertex("v" + String.valueOf(n - i));
                if (i > 0) {
                    int vnr = (int) (Math.random() * i);
                    createArc(varray[vnr].toString() + "-"
                            + varray[i].toString(), varray[vnr], varray[i]);
                    createArc(varray[i].toString() + "-"
                            + varray[vnr].toString(), varray[i], varray[vnr]);
                }
            }
        }

        /**
         * Create an adjacency matrix of this graph.
         * Side effect: corrupts info fields in the graph
         *
         * @return adjacency matrix
         */
        private int[][] createAdjMatrix() {
            info = 0;
            Vertex v = first;
            while (v != null) {
                v.info = info++;
                v = v.next;
            }
            int[][] res = new int[info][info];
            v = first;
            while (v != null) {
                int i = v.info;
                Arc a = v.first;
                while (a != null) {
                    int j = a.target.info;
                    res[i][j]++;
                    a = a.next;
                }
                v = v.next;
            }
            return res;
        }

        /**
         * Create a connected simple (undirected, no loops, no multiple
         * arcs) random graph with n vertices and m edges.
         *
         * @param n number of vertices
         * @param m number of edges
         */
        public void createRandomSimpleGraph(int n, int m) {
            if (n <= 0)
                return;
            if (n > 2500)
                throw new IllegalArgumentException("Too many vertices: " + n);
            if (m < n - 1 || m > n * (n - 1) / 2)
                throw new IllegalArgumentException
                        ("Impossible number of edges: " + m);
            first = null;
            createRandomTree(n);       // n-1 edges created here
            Vertex[] vert = new Vertex[n];
            Vertex v = first;
            int c = 0;
            while (v != null) {
                vert[c++] = v;
                v = v.next;
            }
            int[][] connected = createAdjMatrix();
            int edgeCount = m - n + 1;  // remaining edges
            while (edgeCount > 0) {
                int i = (int) (Math.random() * n);  // random source
                int j = (int) (Math.random() * n);  // random target
                if (i == j)
                    continue;  // no loops
                if (connected[i][j] != 0 || connected[j][i] != 0)
                    continue;  // no multiple edges
                Vertex vi = vert[i];
                Vertex vj = vert[j];
                createArc(vi.toString() + "-" + vj.toString(), vi, vj);
                connected[i][j] = 1;
                createArc(vj.toString() + "-" + vi.toString(), vj, vi);
                connected[j][i] = 1;
                edgeCount--;  // a new edge happily created
            }
        }


        /**
         * Find Eulerian path.
         */
        private void findPath() {
            if (getFirst() == null) throw new RuntimeException("This graph is empty");
            if (getFirst().first == null) {
                System.out.println("Graph " + getId() + " is Eulerian, but it has only one vertex and zero arcs");
                return;
            }
            List<Arc> usedArcs = new ArrayList<>();

            try {
                Arc theArc;
                String reversedArc;
                List<Arc> vertexArcs = mapVertexArcs(getFirst());
                List<Arc> targetVertexArcs;

                while (vertexArcs.size() != 0) {
                    theArc = chooseArc(vertexArcs);
                    theArc.setVisited();
                    targetVertexArcs = mapVertexArcs(theArc.getTarget());
                    reversedArc = reverseString(theArc.getId());

                    for (Arc nextArc : targetVertexArcs) {
                        if (nextArc.getId().contains(reversedArc)) {
                            nextArc.setVisited();
                            targetVertexArcs.remove(nextArc);
                            break;
                        }
                    }
                    usedArcs.add(theArc);
                    vertexArcs = targetVertexArcs;
                }
            } catch (EulerianException e) {
                System.out.println("Graph " + getId() + " does not have an Eulerian cycle");
                return;
            }
            printResult(usedArcs);
        }

        /**
         * Map vertex with arcs.
         *
         * @param vertex vertex
         * @return list of arcs with the same vertex; if graph is not Eulerian, throws an exception
         */
        private List<Arc> mapVertexArcs(Vertex vertex) throws EulerianException {
            List<Arc> vertexArcList = new ArrayList<>();
            Arc arc = vertex.getFirst();

            if (isEulerian(vertex)) {
                while (true) {
                    if (!arc.isVisited()) {
                        vertexArcList.add(arc);
                    }
                    if (arc.getNext() == null) {
                        break;
                    }
                    arc = arc.getNext();
                }
            } else {
                throw new EulerianException();
            }
            return vertexArcList;
        }

        /**
         * Check if graph is Eulerian
         *
         * @param vertex vertex whose arcs are counted
         * @return boolean
         */
        private boolean isEulerian(Vertex vertex) {
            List<Arc> vertexArcList = new ArrayList<>();
            Arc arc = vertex.getFirst();

            while (true) {
                vertexArcList.add(arc);
                if (arc.getNext() == null) {
                    break;
                }
                arc = arc.getNext();
            }
            return vertexArcList.size() % 2 == 0;
        }

        /**
         * Print result.
         *
         * @param l list of used arcs
         */
        private void printResult(List<Arc> l) {
            int counter = 1;
            System.out.println("Graph " + getId() + " has an Eulerian cycle:");
            for (Arc a : l) {
                a.setInfo(counter);
                System.out.print(a.getInfo() + ":" + a.getId() + "  ");
                counter++;
            }
        }

        /**
         * Choose arc for Eulerian path.
         *
         * @param arcList list of arcs
         * @return selected arc
         */
        private Arc chooseArc(List<Arc> arcList) {
            for (Arc a : arcList) {
                if (isBridge(a.getTarget())) {
                    continue;
                }
                if (a.getNext() != null) {
                    return a;
                }
            }
            return arcList.get(0);
        }

        /**
         * Check if arc from the vertex is a bridge
         * @param vertex vertex whose arcs are checked
         * @return boolean
         */
        private boolean isBridge(Vertex vertex) {
            Arc arc = vertex.getFirst();
            int count = 0;
            while (true) {
                if (!arc.isVisited()) {
                    count++;
                }
                if (arc.getNext() == null) {
                    break;
                }
                arc = arc.getNext();
            }
            return count == 1;
        }

        /**
         * Reverse an arc
         *
         * @param s arc
         * @return reversed arc
         */
        private String reverseString(String s) {
            int index = s.indexOf('-');
            return s.substring(index+1) + "-" + s.substring(0,index);
        }

        public void createBigEulerianCycle(int size) {
            int count = 1;
            Vertex firstVertex = new Vertex("v" + count);
            first = firstVertex;
            count++;

            for (int i = 0; i < size; i++) {
                Vertex nextVertex = new Vertex("v" + count);
                count++;
                Arc nextArc = new Arc(firstVertex.id + "-" + nextVertex.id);
                Arc reversedArc = new Arc(nextVertex.id + "-" + firstVertex.id);
                firstVertex.next = nextVertex;
                reversedArc.target = firstVertex;
                nextVertex.first = reversedArc;
                if (firstVertex.first == null) firstVertex.first = nextArc;
                else firstVertex.first.next = nextArc;
                nextArc.target = nextVertex;
                firstVertex = nextVertex;
                if (i == size - 1) {
                    nextArc = new Arc(nextVertex.id + "-" + first.id);
                    nextVertex.first.next = nextArc;
                    nextArc.target = first;
                    reversedArc = new Arc(first.id + "-" + nextVertex.id);
                    first.first.next =  reversedArc;
                    reversedArc.target = nextVertex;
                    nextVertex.next = firstVertex;
                }
            }

        }
    }

    private static class EulerianException extends Exception {
    }
}