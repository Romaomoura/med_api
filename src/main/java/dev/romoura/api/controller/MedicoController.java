package dev.romoura.api.controller;

import dev.romoura.api.domain.Medico;
import dev.romoura.api.domain.record.MedicoRecord;
import dev.romoura.api.domain.repository.MedicoRepository;
import dev.romoura.api.record.MedicoRecordUpdate;
import dev.romoura.api.record.MedicoRecordView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoRecord medico) {
        repository.save(new Medico(medico));
    }

    @GetMapping
    public Page<MedicoRecordView> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable pag) {
        return repository.findAllByAtivoTrue(pag).map(MedicoRecordView::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody MedicoRecordUpdate medicoupdate){
        Medico medico = repository.getReferenceById(medicoupdate.id());
        medico.atualizarInformacoes(medicoupdate);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") Long id){
        Medico medico = repository.getReferenceById(id);
        medico.desativar();
    }

}
