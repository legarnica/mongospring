package cl.lherrera.dto;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AbstractDto<T> implements Serializable {

	private static final long serialVersionUID = -2468811679876395830L;

	private Integer statusCode;
	private List<T> data = new ArrayList<>();
	private String menssaje;

	public AbstractDto(Integer statusCode, List<T> data, String menssaje) {
		super();
		this.statusCode = statusCode;
		this.data = data;
		this.menssaje = menssaje;
	}

	/**
	 * se controla la serjialización de los tipo T de data.
	 */
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
	}

	/**
	 * se controla la serjialización de los tipo T de data.
	 */
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
	}

	public AbstractDto() {
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getMenssaje() {
		return menssaje;
	}

	public void setMenssaje(String menssaje) {
		this.menssaje = menssaje;
	}

}
