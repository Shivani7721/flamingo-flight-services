
import { Passengers } from "./passenger";

export class Reservation {

    constructor(
        public flightId:string,
        public noOfSeats:number,
        public pList:Passengers[]
        ) {  }
  }