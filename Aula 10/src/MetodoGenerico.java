public class MetodoGenerico {

    public <T, A, B> void souGenerico(T t, A a, B b){
        System.out.println(t.getClass().getName()+" "+ a.getClass().getName() +" "+ b.getClass().getName());
    }

}