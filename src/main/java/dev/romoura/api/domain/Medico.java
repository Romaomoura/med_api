package dev.romoura.api.domain;

import dev.romoura.api.domain.record.MedicoRecord;
import dev.romoura.api.domain.record.MedicoRecordUpdate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(MedicoRecord medico) {
        this.nome = medico.nome();
        this.email = medico.email();
        this.crm = medico.crm();
        this.telefone = medico.telefone();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(medico.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(MedicoRecordUpdate medicoupdate) {
        if (medicoupdate.nome() != null) {
            this.nome = medicoupdate.nome();
        }
        if (medicoupdate.telefone() != null) {
            this.telefone = medicoupdate.telefone();
        }
        if (medicoupdate.endereco() != null) {
            this.endereco.atualizarInformacoes(medicoupdate.endereco());
        }
    }
    public void desativar() {
        this.ativo = false;
    }
}
