class test4 {

    public static void main(String[] args) {
	try {
	    test4 t = new test4();
	    t.hello();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    synchronized static void hello() throws Exception {
	test4 t = new test4();
        t.wait();
    }
}

class test5 {

    public void run() throws Exception {
	wait();
    }
}

