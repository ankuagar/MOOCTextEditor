public abstract class SuperClass {
    private String text;

    protected SuperClass(String text) {
        this.text = text;
    }
    protected String giveText() {
        return this.text;
    }
}
