package net.adiherzog.pizza.scenarioo.recorders;

import net.adiherzog.pizza.scenarioo.ScenariooWriterFactory;
import net.adiherzog.pizza.scenarioo.UseCaseContext;
import org.scenarioo.api.ScenarioDocuWriter;
import org.scenarioo.model.docu.entities.Scenario;
import org.scenarioo.model.docu.entities.Status;

public class ScenarioRecorder {

    private UseCaseContext useCaseContext;

    public ScenarioRecorder(UseCaseContext useCaseContext) {
        this.useCaseContext = useCaseContext;
    }

    public void recordScenario() {
        ScenarioDocuWriter scenarioDocuWriter = ScenariooWriterFactory.getNewWriter();
        scenarioDocuWriter.saveScenario(useCaseContext.getUseCaseName(), createScenario());
        scenarioDocuWriter.flush();
    }

    private Scenario createScenario() {
        Scenario scenario = new Scenario();
        scenario.setName(useCaseContext.getScenarioName());
        scenario.setStatus(Status.SUCCESS);
        scenario.setLabels(useCaseContext.getScenarioLabels());
        scenario.setDescription(useCaseContext.getScenarioDescription());
        return scenario;
    }

}