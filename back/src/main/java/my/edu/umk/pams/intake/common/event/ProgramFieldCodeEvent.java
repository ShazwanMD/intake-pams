package my.edu.umk.pams.intake.common.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.connector.payload.ProgramCodePayload;

public class ProgramFieldCodeEvent extends ApplicationEvent {
	
	public ProgramCodePayload payload;

	public ProgramFieldCodeEvent(ProgramCodePayload payload) {
		super(payload);

		this.payload = payload;
	}

	public ProgramCodePayload getPayload() {
		return payload;
	}

	public void setPayload(ProgramCodePayload payload) {
		this.payload = payload;
	}
	
	
	
	

}
