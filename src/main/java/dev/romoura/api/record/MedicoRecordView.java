package dev.romoura.api.record;

import dev.romoura.api.domain.Especialidade;
import dev.romoura.api.domain.Medico;

public record MedicoRecordView(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoRecordView(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
