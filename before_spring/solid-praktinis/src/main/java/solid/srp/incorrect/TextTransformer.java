package solid.srp.incorrect;

import solidCorrect.TransformType;
import solidCorrect.exceptions.TransformationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextTransformer {

    public String transform(TransformType transformType, String text) {
        String result = text;

        switch (transformType) {
            case UPPERCASE:
                result = result.toUpperCase();
                break;
            case LOWERCASE:
                result = result.toLowerCase();
                break;
            default:
                throw new TransformationException(transformType);
        }

        return result;
    }

    public void processUi() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;

            System.out.print("$ ");

            while ((input = reader.readLine()) != null) {
                int colonIdx = input.indexOf(':');
                TransformType transformType = TransformType.valueOf(input.substring(0, colonIdx));
                String text = input.substring(colonIdx + 1);

                String transformed = transform(transformType, text);
                System.out.println("Transformed:" + transformed);

                System.out.print("$ ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to present user interface", e);
        }
    }

    public static void main(String[] args) {
        TextTransformer textTransformer = new TextTransformer();
        textTransformer.processUi();
    }

}
