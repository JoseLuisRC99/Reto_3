package com.example.reto_c3.Service;

import com.example.reto_c3.Model.Partyroom;
import com.example.reto_c3.Repository.PartyroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyroomService {
    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> getAll(){
        return partyroomRepository.getAll();
    }

    public Optional<Partyroom> getPartyroom(int id){
        return partyroomRepository.getPartyroom(id);
    }

    public Partyroom save(Partyroom partyroom){
        if (partyroom.getId() == null){
            return partyroomRepository.save(partyroom);
        }else{
            Optional<Partyroom> partyroomEncontrado = getPartyroom(partyroom.getId());
            if (partyroomEncontrado.isEmpty()){
                return partyroomRepository.save(partyroom);
            }else{
                return partyroom;
            }
        }
    }

    public Partyroom update(Partyroom partyroom){
        if (partyroom.getId() != null){
            Optional<Partyroom> partyroomEncontrado = getPartyroom(partyroom.getId());
            if(!partyroomEncontrado.isEmpty()){
                if (partyroom.getName() != null){
                    partyroomEncontrado.get().setName(partyroom.getName());
                }
                if (partyroom.getOwner() != null){
                    partyroomEncontrado.get().setOwner(partyroom.getOwner());
                }
                if (partyroom.getCapacity() != null){
                    partyroomEncontrado.get().setCapacity(partyroom.getCapacity());
                }
                if (partyroom.getDescription() != null){
                    partyroomEncontrado.get().setDescription(partyroom.getDescription());
                }
                if (partyroom.getCategory() != null){
                    partyroomEncontrado.get().setCategory(partyroom.getCategory());
                }
                return partyroomRepository.save(partyroomEncontrado.get());
            }
        }
        return partyroom;
    }

    public boolean delete(int id){
        Boolean respuesta = getPartyroom(id).map(elemento ->{
            partyroomRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
