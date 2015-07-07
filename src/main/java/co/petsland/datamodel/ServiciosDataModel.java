package co.petsland.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.petsland.model.dto.ServiciosDTO;
  
public class ServiciosDataModel extends ListDataModel<ServiciosDTO> implements SelectableDataModel<ServiciosDTO> {    
  
    public ServiciosDataModel() {  
    }  
  
    public ServiciosDataModel(List<ServiciosDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public ServiciosDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<ServiciosDTO> contacto = (List<ServiciosDTO>) getWrappedData();  
          
        for(ServiciosDTO td : contacto) {          	
            if(td.getSerCodigo().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(ServiciosDTO td) {  
        return td.getSerCodigo();  
    }  

}