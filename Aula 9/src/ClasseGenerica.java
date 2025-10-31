public class ClasseGenerica <T>{
    private T atributo1;
    private T atributo2;
    private T atributo3;
    public ClasseGenerica(T atributo1, T atributo2, T atributo3) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
        this.atributo3 = atributo3;
    }
    
    public T getAtributo2() {
        return atributo2;
    }
    public void setAtributo2(T atributo2) {
        this.atributo2 = atributo2;
    }
    public T getAtributo3() {
        return atributo3;
    }
    public void setAtributo3(T atributo3) {
        this.atributo3 = atributo3;
    }

    public T getAtributo1() {
        return atributo1;
    }

    public void setAtributo1(T atributo1) {
        this.atributo1 = atributo1;
    }

    @Override
    public String toString() {
        return "ClasseGenerica [atributo1=" + atributo1 + ", atributo2=" + atributo2 + ", atributo3=" + atributo3 + "]";
    }

    
    
}