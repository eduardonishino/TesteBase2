package runners;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("tests") // Pacote onde seus testes estão localizados
public class TestRunner {
    // O JUnit executará todos os testes dentro do pacote "tests"
}