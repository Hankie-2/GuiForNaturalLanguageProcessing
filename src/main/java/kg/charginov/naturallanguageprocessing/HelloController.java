package kg.charginov.naturallanguageprocessing;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import kg.charginov.naturallanguageprocessing.http.RestApis;

public class HelloController {
    @FXML
    private Button fillmaskButton;

    @FXML
    private Tab fillmaskTab;

    @FXML
    private TextArea fillmaskTextArea;

    @FXML
    private Text fillmaskedText;

    @FXML
    private Text generatedText;

    @FXML
    private Button generationButton;

    @FXML
    private Tab generationTab;

    @FXML
    private Text predictedText;

    @FXML
    private Button predictionButton;

    @FXML
    private Tab predictionTab;

    @FXML
    private TextArea predictionTextArea;

    @FXML
    private Button summarizationButton;

    @FXML
    private Tab summarizationTab;

    @FXML
    private TextArea summarizationTextArea;

    @FXML
    private Text summarizationedText;

    @FXML
    private TextArea textgenerationTextArea;


    private final RestApis restApi = new RestApis();

    @FXML
    protected void onPredictionButtonClick() {
        String textArea = predictionTextArea.getText();
        predictedText.setText(restApi.getText("prediction",textArea));
    }

    @FXML
    protected void onSummarizationButtonClick() {
        String textArea = summarizationTextArea.getText();
        summarizationedText.setText(restApi.getText("summarization",textArea));
    }

    @FXML
    protected void onFillMaskButtonClick() {
        String textArea = fillmaskTextArea.getText();
        fillmaskedText.setText(restApi.getText("fill-mask",textArea));
    }

    @FXML
    protected void onTextGenerationButtonClick() {
        String textArea = textgenerationTextArea.getText();
        generatedText.setText(restApi.getText("text-generation",textArea));
    }

}