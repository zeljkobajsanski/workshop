package ch.adiutec.workshop.entities
{
	[RemoteClass(alias = "ch.adiutec.workshop.entities.Model")]
	public class Model
	{
		public var id:int;
		public var name:String;
		
		public function Model(){}
		
		public function convertFrom(model:*):void {
			id = model.id;
			name = model.name;
		}
	}
}