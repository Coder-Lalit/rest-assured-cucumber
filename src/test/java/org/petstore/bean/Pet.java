package org.petstore.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {
    private long id;
    private String name;
    private List<String> photoUrls = new ArrayList<String>();
    private String status;

    @Tolerate
    public Pet() {
    }
}
