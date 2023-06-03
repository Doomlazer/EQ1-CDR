;;; Sierra Script 1.0 - (do not remove this comment)
(script# 220)
(include sci.sh)
(use Main)
(use ApartmentRoom)
(use RTRandCycle)
(use Polygon)
(use Obj)

(public
	rm220 0
)

(instance rm220 of ApartmentRoom
	(properties
		picture 220
		style $8007
		east 200
		south 200
	)
	
	(method (init)
		(self
			setRegions: 51
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						-100
						-70
						419
						-70
						419
						178
						319
						178
						281
						145
						285
						106
						306
						64
						283
						26
						223
						11
						116
						15
						37
						50
						28
						113
						61
						151
						167
						170
						248
						189
						248
						259
						-100
						259
					yourself:
				)
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator store: 5 init: 1 0 0 4)
			)
			(4 (EcoNarrator init: 1 0 0 2))
			(44 (EcoNarrator init: 1 0 0 2))
			(2 (EcoNarrator init: 1 0 0 3))
			(6 (EcoNarrator init: 1 0 0 6))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (notify)
		(EcoNarrator init: 1 0 0 1)
		(proc0_2)
	)
)
