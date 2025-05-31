import java.util.ArrayList;

public class ONGs {
    private ArrayList<Animal> animaisDisponiveis = new ArrayList<>();

    public void adicionarAnimal(Animal animal) {
        animaisDisponiveis.add(animal);
    }

    public void listarAnimaisDisponiveis() {
        System.out.println("Animais disponíveis para adoção:");
        for (int i = 0; i < animaisDisponiveis.size(); i++) {
            Animal animal = animaisDisponiveis.get(i);
            if (!animal.isAdotado()) {
                System.out.println((i+1) + " - " + animal.getNome() + " (" + animal.getRaca() + ", " + animal.getIdade() + " anos)");
            }
        }
    }

    public ArrayList<Animal> getAnimaisDisponiveis() {
        return animaisDisponiveis;
    }
    
    // Métodos adicionais para acessar atributos
    public String getNomeAnimal(int index) {
        return animaisDisponiveis.get(index).getNome();
    }
    
    public String getRacaAnimal(int index) {
        return animaisDisponiveis.get(index).getRaca();
    }
    
    public int getIdadeAnimal(int index) {
        return animaisDisponiveis.get(index).getIdade();
    }
}