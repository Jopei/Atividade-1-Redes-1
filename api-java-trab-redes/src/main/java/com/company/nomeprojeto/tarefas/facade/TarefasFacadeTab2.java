package com.company.nomeprojeto.tarefas.facade;

import com.company.nomeprojeto.tarefas.api.TarefasAPI;
import com.company.nomeprojeto.tarefas.dto.TarefaDTO2;
import com.company.nomeprojeto.tarefas.dto.TarefaDTO;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TarefasFacadeTab2 {

    private static final Map<Long, TarefaDTO2> tarefas = new HashMap<>();
    public TarefaDTO2 criar(TarefaDTO2 tarefaDTO){
        Long proximoId = tarefas.keySet().size() +1L;
        tarefaDTO.setId(proximoId);
        tarefas.put(proximoId, tarefaDTO);

        return tarefaDTO;
    }
    public TarefaDTO2 atualizar (TarefaDTO2 tarefaDTO, Long tarefaId){
        tarefas.put(tarefaId, tarefaDTO);
        return tarefaDTO;
    }
    public TarefaDTO2 getById(Long tarefaId){
        return tarefas.get(tarefaId);
    }
    public List<TarefaDTO2> getALL(){
        return new ArrayList<>(tarefas.values());
    }
    public String delete (Long tarefaId){
        tarefas.remove(tarefaId);
        return "DELETED";
    }
}
