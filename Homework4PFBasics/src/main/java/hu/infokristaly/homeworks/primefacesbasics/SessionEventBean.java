package hu.infokristaly.homeworks.primefacesbasics;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@SessionScoped
@Named
public class SessionEventBean implements Serializable {

	private static final long serialVersionUID = -709485967219558126L;

	private String watermark;
	private String target;
	private String targetOption;
	private String renderTarget;
	private List<DialogCMD> commands = new LinkedList<DialogCMD>();

	public String getWatermark() {
		if (watermark == null) {
			watermark = "Szig.szám";
		}
		return watermark;
	}

	@PostConstruct
	public void init() {
		DialogCMD cmd = new DialogCMD();

		cmd.setDao(new IDAO() {
			@Override
			public String execute() {
				addMessage("complete.");
				return "index.xhtml";
			}
		});
		cmd.setValue("UNO");
		cmd.setUpdate("growl");
		cmd.setOncomplete("oncomplete()");
		commands.add(cmd);
	}

	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  summary);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
		
	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTargetOption() {
		return targetOption;
	}

	public void setTargetOption(String targetOption) {
		this.targetOption = targetOption;
	}

	public String getRenderTarget() {
		if (target == null || (target != null && target.isEmpty())) {
			renderTarget = "selectTargetGrid";
		} else {
			renderTarget = "";
		}
		return renderTarget;
	}

	public void setRenderTarget(String renderTarget) {
		this.renderTarget = renderTarget;
	}

	public void targetChanged(ValueChangeEvent event) {
		watermark = (String) event.getNewValue();
	}

	public List<DialogCMD> getCommands() {
		return commands;
	}

	public void setCommands(List<DialogCMD> commands) {
		this.commands = commands;
	}

}
