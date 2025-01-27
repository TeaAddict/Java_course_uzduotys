package solidCorrect;

import solidCorrect.TransformType;
import solidCorrect.exceptions.TransformationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

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
            case SPLIT:
                result = String.join(" ", result.split(""));
                break;
            default:
                throw new TransformationException(transformType);
        }

        return result;
    }


}
