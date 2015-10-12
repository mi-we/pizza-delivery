package net.adiherzog.pizza.scenarioo;

import net.adiherzog.pizza.infrastructure.WebDriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.scenarioo.api.ScenarioDocuWriter;
import org.scenarioo.model.docu.entities.Step;
import org.scenarioo.model.docu.entities.StepDescription;
import org.scenarioo.model.docu.entities.StepHtml;

import java.io.File;

public class ScenariooEventListener extends AbstractWebDriverEventListener {

    private StepRecorder stepRecorder;

    public ScenariooEventListener(UseCaseContext useCaseContext) {
       this.stepRecorder = new StepRecorder(useCaseContext);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);

        // Records a step in Scenarioo before each click
        stepRecorder.recordStep(driver);
    }

}
