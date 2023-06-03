;;; Sierra Script 1.0 - (do not remove this comment)
(script# 201)
(include sci.sh)
(use Main)
(use Smopper)
(use n819)
(use Cycle)
(use InvI)
(use Obj)

(public
	delExit 0
)

(local
	local0
)
(procedure (localproc_085c param1 param2 &tmp temp0)
	(= temp0 (!= param1 local0))
	(= local0 param1)
	(if (and temp0 (== argc 2))
		(param2 start: (param2 state?))
		(gDelph talkScript: param2)
	else
		(gDelph talkScript: 0)
		(if (!= gNumber 200) (proc819_3 107))
	)
	(return temp0)
)

(instance delExit of Script
	(properties)
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 201)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_7)
				(gDelph
					loop: 0
					cel: 6
					posn: 182 91
					xStep: 7
					z: 0
					heading: 90
					setPri: 0
					init:
					lookStr: 15
				)
				(= cycles 3)
			)
			(1
				(gDelph setMotion: MoveTo 266 91 self)
			)
			(2
				(gDelph setCycle: Smopper 836 0 0 20 setHeading: 180 self)
			)
			(3
				(if (not (proc819_3 76))
					((ScriptID 2 0) init: 3 0 0 2 1 self)
				else
					(= cycles 1)
				)
			)
			(4
				(cond 
					((proc819_5 116) (self setScript: HDirtyShell self))
					((not (proc819_5 29)) (self setScript: HBeforeOracle self))
					((not (proc819_5 4)) (self setScript: HFinishOracle self))
					(
					(and (not (proc819_5 27)) (not (proc819_5 11))) (self setScript: HBeforeMayor self))
					((and (proc819_5 2) (not (proc819_5 11))) (self setScript: HTalkToSuperfl self))
					(
						(and
							(proc819_5 3)
							(not (proc819_5 2))
							(not (proc819_5 11))
						)
						(self setScript: HBeforeSuperfl self)
					)
					((and (proc819_5 11) (not (proc819_5 27))) (self setScript: HBeforeDemeter self))
					((and (proc819_5 27) (not (proc819_5 3))) (self setScript: HNoCouncilChambers self))
					(
						(and
							(proc819_5 11)
							(proc819_5 27)
							(not (== ((Inv at: 22) owner?) 160))
						)
						(self setScript: HNoShell self)
					)
				)
			)
			(5
				(if (not (global2 script?)) (proc0_2))
				(= seconds 10)
			)
			(6
				(if (not (global2 script?))
					(proc0_1)
					((ScriptID 2 0) init: 3 0 0 25 1 self)
				)
			)
			(7
				(gDelph talkScript: 0 setMotion: MoveTo 376 9 self)
			)
			(8
				(if (not (global2 script?)) (proc0_2))
				(gDelph dispose:)
				(self dispose:)
			)
		)
	)
)

(instance HBeforeOracle of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 0 0 3 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 5 1 self)
			)
			(2
				(if (localproc_085c 1 self)
					((ScriptID 2 0) init: 3 0 0 4 1 self)
				else
					((ScriptID 2 0) init: 3 0 0 5 1 self)
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance HFinishOracle of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 0 0 3 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 17 1 self)
			)
			(2
				(if (localproc_085c 2 self)
					((ScriptID 2 0) init: 3 0 0 26 1 self)
				else
					((ScriptID 2 0) init: 3 0 0 27 1 self)
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance HBeforeMayor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 0 0 6 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 5 1 self)
			)
			(2
				(if (localproc_085c 3 self)
					((ScriptID 2 0) init: 3 0 0 10 1 self)
				else
					((ScriptID 2 0) init: 3 0 0 11 1 self)
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance HBeforeSuperfl of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 0 0 6 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 8 1 self)
			)
			(2
				((ScriptID 2 0) init: 3 0 0 13 1 self)
			)
			(3
				((ScriptID 2 1) init: 2 0 0 9 1 self)
			)
			(4
				(if (localproc_085c 4 self)
					((ScriptID 2 0) init: 3 0 0 14 1 self)
				else
					((ScriptID 2 0) init: 3 0 0 28 1 self)
				)
			)
			(5 (self dispose:))
		)
	)
)

(instance HTalkToSuperfl of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 0 0 6 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 18 1 self)
			)
			(2
				(if (localproc_085c 6 self)
					((ScriptID 2 0) init: 3 0 0 29 1 self)
				else
					((ScriptID 2 0) init: 3 0 0 30 1 self)
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance HBeforeDemeter of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 0 0 6 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 10 1 self)
			)
			(2
				(if (localproc_085c 5 self)
					((ScriptID 2 0) init: 3 0 0 16 1 self)
				else
					((ScriptID 2 0) init: 3 0 0 17 1 self)
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance HNoCouncilChambers of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 0 0 6 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 11 1 self)
			)
			(2
				(if (localproc_085c 7 self)
					((ScriptID 2 0) init: 3 0 0 19 1 self)
				else
					((ScriptID 2 0) init: 3 0 0 11 1 self)
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance HNoShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 0 0 6 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 12 1 self)
			)
			(2
				((ScriptID 2 0) init: 3 0 0 21 1 self)
			)
			(3
				((ScriptID 2 1) init: 2 0 0 13 1 self)
			)
			(4
				((ScriptID 2 0) init: 3 0 0 22 1 self)
			)
			(5
				((ScriptID 2 1) init: 2 0 0 14 1 self)
			)
			(6
				(if (localproc_085c 8 self)
					((ScriptID 2 0) init: 3 0 0 23 1 self)
				else
					((ScriptID 2 0) init: 3 0 0 31 1 self)
				)
			)
			(7 (self dispose:))
		)
	)
)

(instance HDirtyShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 3 0 0 41 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 19 1 self)
			)
			(2
				(if (localproc_085c 9 self)
					((ScriptID 2 0) init: 3 0 0 32 1 self)
				else
					((ScriptID 2 0) init: 3 0 0 33 1 self)
				)
			)
			(3 (self dispose:))
		)
	)
)
