package solidCorrect;

public class Main {
    public static void main(String[] args) {
        TextTransformer textTransformer = new TextTransformer();
//        textTransformer.processUi();
        ProcessUi processor = new ProcessUi(textTransformer);
        processor.processUi();
    }
}
