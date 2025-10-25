public class Pessoa implements Segurado {
    private int idade;
    private boolean eHomem;

    public Pessoa(int idade, boolean eHomem) {
        this.idade = idade;
        this.eHomem = eHomem;
    }

    @Override
    public double calcularPremio(){
        if (idade >= 0 && idade <= 59) {
            return ((idade/10)+1) * 100;
        } else if (eHomem) {
            return 800;
        } else {
            return 700;
        }
    }

    @Override
    public String toString() {
        return "Pessoa\nIdade: " + idade + " Genero: " + (eHomem ? "Homem " : "Mulher ") + "Valor do Premio: R$" + calcularPremio();
    }
}
