package Controller;


import Model.Partyroom;
import Service.PartyroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE
})
@RestController
@RequestMapping("/api/Partyroom")
public class PartyroomController {
    @Autowired
    private PartyroomService partyroomService;

    @GetMapping("/all")
    public List<Partyroom> getAll(){
        return partyroomService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Partyroom> getPartyroom(@PathVariable("id") int id){
        return partyroomService.getPartyroom(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom client){
        return partyroomService.save(client);
    }
}
