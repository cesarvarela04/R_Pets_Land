package co.petsland.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.petsland.model.dto.VeterinariasDTO;

  
public class VeterinariasDataModel extends ListDataModel<VeterinariasDTO> implements SelectableDataModel<VeterinariasDTO> {    
  
    public VeterinariasDataModel() {  
    }  
  
    public VeterinariasDataModel(List<VeterinariasDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public VeterinariasDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<VeterinariasDTO> contacto = (List<VeterinariasDTO>) getWrappedData();  
          
        for(VeterinariasDTO td : contacto) {          	
            if(td.getVetCodigo().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(VeterinariasDTO td) {  
        return td.getVetCodigo();  
    }  

}