package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// responsável por carregar propriedades de configuração de um arquivo config.properties. Esse bloco específico é um bloco estático que é executado automaticamente quando a classe ConfigLoader é carregada pela primeira vez.
public class ConfigLoader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao carregar config.properties");
        }
    }

    //Responsável por recuperar o valor associado a uma determinada chave no arquivo config.properties. Ele garante que a propriedade desejada esteja disponível e lança uma exceção se a chave não for encontrada.
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Propriedade '" + key + "' não encontrada no arquivo config.properties");
        }
        return value;
    }
}
