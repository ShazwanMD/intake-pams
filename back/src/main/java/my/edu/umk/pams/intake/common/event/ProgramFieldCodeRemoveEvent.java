package my.edu.umk.pams.intake.common.event;

import my.edu.umk.pams.connector.payload.ProgramCodePayload;

public class ProgramFieldCodeRemoveEvent extends ProgramFieldCodeEvent {

	public ProgramFieldCodeRemoveEvent(ProgramCodePayload payload) {
		super(payload);
	}

}
