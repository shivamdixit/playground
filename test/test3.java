class one {
    protected int a;
}

class two extends one {
    void testMe() {
	this.a = 10;
    }
}

class myclass {
    public static void main(String args[]) {
	one t = new one();
	t.a = 10;
    }
}
