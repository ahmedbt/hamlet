package ba.ahmed.boot.elastic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by USER on 8/31/2017.
 */
@Document(indexName = "shakespeare", type = "line")
public class Citat {

    @Id
    @JsonProperty("line_id")
    private Integer lineId;

    @JsonProperty("play_name")
    private String playName;

    @JsonProperty("speech_number")
    private int speechNumber;

    @JsonProperty("line_number")
    private String lineNumber;

    @JsonProperty("speaker")
    private String speaker;

    @JsonProperty("text_entry")
    private String textEntry;

    public Citat() {
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public int getSpeechNumber() {
        return speechNumber;
    }

    public void setSpeechNumber(int speechNumber) {
        this.speechNumber = speechNumber;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getTextEntry() {
        return textEntry;
    }

    public void setTextEntry(String textEntry) {
        this.textEntry = textEntry;
    }
}
