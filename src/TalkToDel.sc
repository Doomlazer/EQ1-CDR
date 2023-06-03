;;; Sierra Script 1.0 - (do not remove this comment)
(script# 241)
(include sci.sh)
(use Main)
(use Obj)

(public
	TalkToDel 0
)

(instance TalkToDel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(cond 
					((== global234 1) (= state 3))
					((== global234 2) (= state 6))
				)
				(= cycles 1)
			)
			(1
				(= global234 1)
				((ScriptID 2 1) init: 1 0 0 1 1 self)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 2 1 self)
			)
			(3 (= state 9) (= cycles 1))
			(4
				(= global234 2)
				((ScriptID 2 1) init: 1 0 0 2 1 self)
			)
			(5
				((ScriptID 2 0) init: 2 0 0 3 1 self)
			)
			(6 (= state 9) (= cycles 1))
			(7
				(= global234 0)
				((ScriptID 2 1) init: 1 0 0 3 1 self)
			)
			(8
				((ScriptID 2 0) init: 2 0 0 4 1 self)
			)
			(9
				((ScriptID 2 1) init: 1 0 0 4 1 self)
			)
			(10 (proc0_2) (self dispose:))
		)
	)
)
