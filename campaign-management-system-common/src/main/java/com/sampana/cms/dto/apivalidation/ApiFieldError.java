package com.sampana.cms.dto.apivalidation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * /**
	 * @author Sudhanshu Chaturvedi
	 */

@JsonInclude(Include.NON_NULL)
public class ApiFieldError {
    private String field;
    private String code;
    private Object rejectedValue;
    private String error;

    public ApiFieldError(String field, String code, Object rejectedValue,String error) {
        this.field = field;
        this.code = code;
        this.rejectedValue = rejectedValue;
        this.error = error;
    }
    
    public ApiFieldError(String field,String error) {
        this.field = field;
        this.error = error;
    }
    
    

    public String getField() {
        return field;
    }

    public String getCode() {
        return code;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }
    

    /**
	 * @return the errorMsg
	 */
	public String getError() {
		return error;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiFieldError that = (ApiFieldError) o;

        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (error != null ? !error.equals(that.error) : that.error != null) return false;
        return rejectedValue != null ? rejectedValue.equals(that.rejectedValue) : that.rejectedValue == null;

    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (rejectedValue != null ? rejectedValue.hashCode() : 0);
        result = 31 * result + (error != null ? error.hashCode() : 0);
        return result;
    }

}
