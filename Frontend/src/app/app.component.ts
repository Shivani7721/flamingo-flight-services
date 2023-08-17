import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public source:String = "";
  public destination:String = "";
  public journeyDate:Date= new Date();

  
  public onSubmit(data:any)
  {
    console.log(this.source);
    console.log(this.destination);
    console.log(this.journeyDate);
  }
}
