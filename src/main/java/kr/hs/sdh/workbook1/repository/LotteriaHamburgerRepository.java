package kr.hs.sdh.workbook1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.hs.sdh.workbook1.entity.Hamburger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public final class LotteriaHamburgerRepository implements HamburgerRepository, InitializingBean {

    private final ObjectMapper objectMapper;

    @Value(value = "classpath:static/lotteria-menu.json")
    private Resource lotteriaMenuResource;

    private Set<Hamburger> hamburgers;

    public LotteriaHamburgerRepository(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try (var inputStream = lotteriaMenuResource.getInputStream()) {
            final var hamburgerTypeReference = new TypeReference<Set<Hamburger>>() {};

            this.hamburgers = this.objectMapper.readValue(inputStream, hamburgerTypeReference);
        }
    }

    @Override
    public Set<Hamburger> findHamburgers() {
        return this.hamburgers;
    }

    @Override
    public void deleteHamburger(Hamburger hamburger) {
        if(this.hamburgers.contains(hamburger)) {
            this.hamburgers.remove(hamburger);
        }
    }

    @Override
    public void saveHamburger(Hamburger hamburger) {
//        if (hamburgers.contains(hamburger)){
//            hamburgers.set(hamburgers.indexOf(hamburger), hamburger);
//        }else {
//            hamburgers.add(hamburger);
//
//        }
        boolean isHamburger = this.hamburgers.contains(hamburger);
        if (isHamburger) {
            this.hamburgers.remove(hamburger);
        }
        this.hamburgers.add(hamburger);

    }

}