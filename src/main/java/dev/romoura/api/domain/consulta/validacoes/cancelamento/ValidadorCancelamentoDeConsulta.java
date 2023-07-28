package dev.romoura.api.domain.consulta.validacoes.cancelamento;

import dev.romoura.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);

}
