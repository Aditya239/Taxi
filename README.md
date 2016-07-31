# Taxi
A bare bones central routing system for a collection of taxis on a map with focus on quickest service. Course Project.
Useful Information:
Information in the map1 file should be formatted as under:
Any route say between X and Y with known time of travel say T
should be reported in a single line as

edge X Y T

A new taxi named say <Name> may be introduced at a starting location say <L>
in a single line as

taxi <Name> <L>

To print out taxi positions at a time t, (Note dynamic positions as for
moving taxis is under construction), use

printTaxiposition t

For a customer request to travel from say S to D at hailed a time t, use

customer S D t

Future:
Dynamic Updates and traffic (time updates for routes) notifs
Shared Taxis at locations en route?