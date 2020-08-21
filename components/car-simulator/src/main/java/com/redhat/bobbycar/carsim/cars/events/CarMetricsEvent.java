package com.redhat.bobbycar.carsim.cars.events;

import java.util.Objects;
import java.util.UUID;

import com.redhat.bobbycar.carsim.cars.Car;
import com.redhat.bobbycar.carsim.cars.EngineData;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class CarMetricsEvent {
	private EngineData engineData;
	private String model;
	private String manufacturer;
	private UUID driverId;

	public CarMetricsEvent() {

	}

	public CarMetricsEvent(EngineData engineData, String model, String manufacturer, UUID driverId) {
		super();
		this.engineData = engineData;
		this.model = model;
		this.manufacturer = manufacturer;
		this.driverId = driverId;
	}

	public static CarMetricsEvent create(Car car, EngineData currentData) {
		return new CarMetricsEvent(currentData, car.getModel(), car.getManufacturer(), car.getDriverId());
	}

	public EngineData getEngineData() {
		return engineData;
	}

	public void setEngineData(EngineData engineData) {
		this.engineData = engineData;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public UUID getDriverId() {
		return driverId;
	}

	public void setDriverId(UUID driverId) {
		this.driverId = driverId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(driverId, engineData, manufacturer, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarMetricsEvent other = (CarMetricsEvent) obj;
		return Objects.equals(driverId, other.driverId) && Objects.equals(engineData, other.engineData)
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(model, other.model);
	}

	@Override
	public String toString() {
		return String.format("EngineMetricsEvent [engineData=%s, model=%s, manufacturer=%s, driverId=%s]", engineData,
				model, manufacturer, driverId);
	}
}
