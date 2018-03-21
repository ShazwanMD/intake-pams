package my.edu.umk.pams.intake.common.event;

import my.edu.umk.pams.connector.payload.ProgramCodePayload;

public class ProgramFieldCodeAddedEvent extends ProgramFieldCodeEvent {

	public ProgramFieldCodeAddedEvent(ProgramCodePayload payload) {
		super(payload);
	}

}
