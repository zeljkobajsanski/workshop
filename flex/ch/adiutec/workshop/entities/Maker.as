package ch.adiutec.workshop.entities
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias = "ch.adiutec.workshop.entities.Maker")]
	public class Maker
	{
		public var id:int;
		public var name:String;
		public var models:ArrayCollection = new ArrayCollection();
		
		public function Maker(){}
		
		public function convertFrom(maker:*) : void{
			id = maker.id;
			name = maker.name;
			var models:ArrayCollection = new ArrayCollection();
			for each (var m:Model in maker.models) 
			{
				var model:Model = new Model();
				model.convertFrom(m);
				models.addItem(model);
			}
			this.models = models;
		}
	}
}