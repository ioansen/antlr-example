grammar DIV;

div :   'DIV'NL
         standardIdentification
         diversionInformation
         supplementaryInformation
    ;

standardIdentification
    :  airlineDesignator
       flightNumber
       '/'
       dateOfMonth
       '.'
       aircraftRegistration
       '.'
       airportCodeLanding
       NL
    ;

airlineDesignator
    :   (A|F) (A|F) A?
    ;

flightNumber
    :   F F F F? A?
    ;

dateOfMonth
    :   F F
    ;

aircraftRegistration
    :   (A|F) (A|F) (A|F)? (A|F)? (A|F)? (A|F)? (A|F)? (A|F)? (A|F)? (A|F)?
    ;

airportCodeLanding
    :   A A A   ;

diversionInformation
    :   estimatedArrival
        NL
        reasonForDiversion?
        numberOfPassangers?
    ;

estimatedArrival
    :   estimatedArrivalId
        estimatedArrivalTime
        ' '
        airportCodeDiversion
    ;

estimatedArrivalId
    :   A A ;

estimatedArrivalTime
    :   F F F F ;

airportCodeDiversion
    :   A A A   ;

reasonForDiversion
    :   reasonForDiversionId
        reasonCode
        ' '
    ;

reasonForDiversionId
    :   A A ;

reasonCode
    :   (A|F) (A|F) ;

numberOfPassangers
    :   passangerOnBoardId
        totalNumberOfSeatsOccupied
        NL
        estimatedOnBlockTimeIdentifier?
        flightLegDateIndicator?
        flightTerminationIndicator?
        flightContinuationIndicator?
        estimatedDepartureTime?
    ;

passangerOnBoardId
    :   A A ;

totalNumberOfSeatsOccupied
    :   F F? F? ;

estimatedOnBlockTimeIdentifier
    :   'EB' F F F F NL ;

flightLegDateIndicator
    :   'FLD' F F NL    ;

flightTerminationIndicator
    :   'TERM' NL   ;

flightContinuationIndicator
    :   'CONT ' A A A NL ;

estimatedDepartureTime
    :   'ED' F F F F F F NL ;

supplementaryInformation
    :   SUP    ;


A   :   [A-Z]   ;
F   :   [0-9]   ;
SUP :   'SI ' (A|' ' )+    ;

NL  :   '\r'? '\n'  ;