import java.util.List;

public class FuncionarioProxy implements IFuncionario{
    private Funcionario funcionario;
    private String matricula;

    public FuncionarioProxy(String matricula){
        this.matricula = matricula;
    }


    @Override
    public List<String> obterDadosPessoais() {
        if(this.funcionario == null){
            this.funcionario = new Funcionario(1, this.matricula, 950.0f);
        }
        return this.funcionario.obterDadosPessoais();
    }

    @Override
    public List<Float> obterSalario(Empresario empresario) {
        if(!empresario.isGerente()){
            throw new IllegalArgumentException("Socio nao autorizado");
        }
        if(this.funcionario == null){
            this.funcionario = new Funcionario(1, this.matricula, 950.0f);
        }

        return this.funcionario.obterSalario(empresario);
    }
}
