;;; Sierra Script 1.0 - (do not remove this comment)
(script# 63)
(include sci.sh)
(use Main)
(use Obj)

(public
	lookAtScreen 0
)

(instance lookAtScreen of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 63)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gCast eachElementDo: #hide)
				(gEgo stopUpd:)
				(= register (= register ((ScriptID 400 11) script?)))
				((ScriptID 400 11) script: 0)
				(global2 drawPic: 1 -32761)
				(= seconds (= seconds 3))
			)
			(1
				((ScriptID 2 1) init: 2 0 0 30 1 self)
			)
			(2 (= seconds (= seconds 3)))
			(3 (= cycles (= cycles 3)))
			(4
				(global2 drawPic: 400 -32762)
				(gCast eachElementDo: #show)
				((ScriptID 400 12) addToPic:)
				((ScriptID 400 11) hide: script: register)
				(proc0_2)
				(gEgo startUpd:)
				(self dispose:)
			)
		)
	)
)
