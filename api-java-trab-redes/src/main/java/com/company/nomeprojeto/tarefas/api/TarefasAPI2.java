package com.company.nomeprojeto.tarefas.api;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import com.company.nomeprojeto.tarefas.dto.TarefaDTO2;
import com.company.nomeprojeto.tarefas.facade.TarefasFacadeTab1;
import com.company.nomeprojeto.tarefas.facade.TarefasFacadeTab2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/tarefasTab2", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPI2 {
    @Autowired
    private TarefasFacadeTab2 tarefasFacade;

    @PostMapping
    @ResponseBody
    public TarefaDTO2 criar(@RequestBody TarefaDTO2 tarefaDTO) {
        double percurso;
        double transporte = 1;
        int carga;
        double custoTotal;
        TarefasFacadeTab1 aux = new TarefasFacadeTab1() ;
        List<TarefaDTO> lista = aux.getALL();

        for(int i = 0; i < lista.size(); i++ ){
            if(lista.get(i).getVeiculo().equals(tarefaDTO.getVeiculoUtilizado())){
                percurso = (tarefaDTO.getDistanciaPav() * 0.63) + (tarefaDTO.getDistanciaNaoPav() * 0.72);
                carga = tarefaDTO.getCarga();
                if (carga <= 5){
                    transporte = lista.get(i).getFatorMult();
                }else{
                    transporte = lista.get(i).getFatorMult() + ((carga - 5) * 0.03 );
                }
                custoTotal = percurso * transporte;
                tarefaDTO.setCustoTotal(custoTotal);
            }
        }

        return tarefasFacade.criar(tarefaDTO);
    }

    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDTO2 atualizar(@PathVariable("tarefaId") Long tarefaID, @RequestBody TarefaDTO2 tarefaDTO) {

        double percurso;
        double transporte = 1;
        int carga;
        double custoTotal;
        TarefasFacadeTab1 aux = new TarefasFacadeTab1() ;
        List<TarefaDTO> lista = aux.getALL();

        for(int i = 0; i < lista.size(); i++ ){
            if(lista.get(i).getVeiculo().equals(tarefaDTO.getVeiculoUtilizado())){
                percurso = (tarefaDTO.getDistanciaPav() * 0.63) + (tarefaDTO.getDistanciaNaoPav() * 0.72);
                carga = tarefaDTO.getCarga();
                if (carga <= 5){
                    transporte = lista.get(i).getFatorMult();
                }else{
                    transporte = lista.get(i).getFatorMult() + ((carga - 5) * 0.03 );
                }
                custoTotal = percurso * transporte;
                tarefaDTO.setCustoTotal(custoTotal);
            }
        }
        return tarefasFacade.atualizar(tarefaDTO, tarefaID);
    }

    @GetMapping
    @ResponseBody
    public List<TarefaDTO2> getALL() {
        return tarefasFacade.getALL();
    }

    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String deletar(@PathVariable("tarefaId") Long tarefaId) {
        return tarefasFacade.delete(tarefaId);
    }

}
