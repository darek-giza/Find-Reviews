package pl.com.dariusz.giza.FindReviews.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.dto.PlaceDto;
import pl.com.dariusz.giza.FindReviews.model.Places;

@Service
public class PlaceMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public PlaceMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlaceDto convertPlaceToDto(Places places){
        return modelMapper.map(places, PlaceDto.class);
    }
}
