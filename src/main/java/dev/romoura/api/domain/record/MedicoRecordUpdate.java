package dev.romoura.api.domain.record;

import dev.romoura.api.domain.record.EnderecoRecord;
import jakarta.validation.constraints.NotNull;

public record MedicoRecordUpdate(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoRecord endereco) {
}
