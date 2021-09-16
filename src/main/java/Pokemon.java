import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {

    @JsonProperty("base_experience")
    private int baseExperience;
    private Form[] forms;

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public Form[] getForms() {
        return forms;
    }

    public void setForms(Form[] forms) {
        this.forms = forms;
    }
}
