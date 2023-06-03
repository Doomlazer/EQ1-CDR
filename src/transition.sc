;;; Sierra Script 1.0 - (do not remove this comment)
(script# 122)
(include sci.sh)
(use Main)
(use n819)
(use Cycle)
(use Obj)

(public
	transition 0
)

(instance transition of Script
	(properties)
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 122)
	)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_6)
				(gEgo setPri: 7 setMotion: MoveTo 181 111 self)
			)
			(1
				(proc819_7)
				(gDelph
					posn: 8 -15
					z: 0
					ignoreActors:
					ignoreHorizon:
					setPri: 7
					init:
					setMotion: MoveTo 99 101 self
				)
			)
			(2 (= seconds 2))
			(3
				((ScriptID 2 0) init: 1 0 0 3 1 self)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 2 1 self)
			)
			(5
				((ScriptID 2 0) init: 1 0 0 4 1 self)
			)
			(6
				(= temp0 (if (proc819_5 27) 10 else 3))
				((ScriptID 2 1) init: 2 0 0 temp0 1 self)
			)
			(7
				((ScriptID 2 0) init: 1 0 0 5 1 self)
			)
			(8
				(gDelph setMotion: MoveTo 15 -60 self)
			)
			(9
				(gDelph hide:)
				(proc819_6 1)
				(gEgo ignoreHorizon: setPri: 7)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)
