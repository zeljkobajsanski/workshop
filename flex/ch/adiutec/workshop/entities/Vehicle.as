package ch.adiutec.workshop.entities
{
	import flash.utils.ByteArray;
	import flash.utils.Dictionary;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias = "ch.adiutec.workshop.entities.Vehicle")]
	public class Vehicle
	{
		public var id:int;
		private var _model:Model;
		private var _maker:Maker;
		public var plate:String;
		public var engine:String;
		public var vehicleId:String;
		public var color:String;
		public var image:ByteArray;
		private var _description:String;
		public var power:int;
		public var year:int;
		public var volume:int;
		public var mass:int;
		public var weight:int;
		public var price:int;
		public var odometer:int;
		public var fuelType:FuelType;
		
		public function Vehicle()
		{
		}
		
		public function set maker(maker:Maker):void {
			_maker = maker;
		}
		
		public function get maker():Maker {
			return _maker;
		}
		
		public function set model(model:Model):void {
			_model = model;
		}
		
		public function get model():Model {
			return _model;
		}
		
		public function get description():String {
			return _description;
		}
		
		public function set description(description:String):void {
			_description = description;
		}
		
		public function convertFrom(vehicle:*):void 
		{
			this.id = vehicle.id;
			this.maker = vehicle.maker;
			this.model = vehicle.model;
			this.image = vehicle.image;
			this.plate = vehicle.plate;
			this.color = vehicle.color;
			this.engine = vehicle.engine;
			this.vehicleId = vehicle.vehicleId;
			this.description = vehicle.description;
			this.year = vehicle.year;
			this.price = vehicle.price;
			this.odometer = vehicle.odometer;
			this.power = vehicle.power;
			this.volume = vehicle.volume;
			this.weight = vehicle.weight;
			this.fuelType = vehicle.fuelType;
		}
	}
}