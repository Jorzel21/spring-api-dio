package jorzel.springprojectapi.service.viaCep;

import jorzel.springprojectapi.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "addressZipCode", url="https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping(value= "/{cep}/json/")
    Address searchZipCode(@PathVariable("cep") String cep);
}
